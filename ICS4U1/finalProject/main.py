import nextcord
import os
import random
import asyncio
from dotenv import load_dotenv
from pathlib import Path
from nextcord import Interaction
from nextcord.ext import commands

# Load environment variables
env_path = Path('C:/Users/liamt/OneDrive/Documents/GitHub/learning/ICS4U1/finalProject/token.env')
load_dotenv(dotenv_path=env_path)
DISCORD_TOKEN = os.getenv("DISCORD_TOKEN")

# Game Definitions
suits = ['<:Hearts:1248247512389914726>', '<:Diamonds:1248142085651959870>', '<:Clubs:1248142071915876394>', '<:Spades:1248142013480570900>']
ranks = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
values = {'2': 2, '3': 3, '4': 5, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, '10': 10, 'J': 10, 'Q': 10, 'K': 10, 'A': 11}
rankIcons = {
    '2': '<:Two:1248322560928780298>', '3': '<:Three:1248322584139796511>', '4': '<:Four:1248322602137686066>',
    '5': '<:Five:1248322620529840269>', '6': '<:Six:1248322643556434102>', '7': '<:Seven:1248322665932914733>',
    '8': '<:Eight:1248322681741512726>', '9': '<:Nine:1248322705447719004>', '10': '<:Ten:1248322728939753563>',
    'J': '<:Jack:1248322762678997105>', 'Q': '<:Queen:1248322799618232401>', 'K': '<:King:1248322819650097204>',
    'A': '<:Ace:1248322837668827279>'
}

def create_deck():
    deck = [{'rank': rank, 'suit': suit} for suit in suits for rank in ranks]
    random.shuffle(deck)
    return deck

def calculate_hand_value(hand):
    value = sum(values[card['rank']] for card in hand)
    num_aces = sum(card['rank'] == 'A' for card in hand)
    while value > 21 and num_aces:
        value -= 10
        num_aces -= 1
    return value

def display_hand(hand):
    return ', '.join(f"{rankIcons[card['rank']]}{card['suit']}" for card in hand)

# Connect 4 game definitions
empty_slot = "⚪"
red_slot = "🔴"
yellow_slot = "🟡"
columns = ["1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣"]

def create_board():
    return [[empty_slot for _ in range(7)] for _ in range(6)]

def display_board(board):
    return "\n".join(["".join(row) for row in board])

def drop_piece(board, col, piece):
    for row in reversed(board):
        if row[col] == empty_slot:
            row[col] = piece
            return True
    return False

def check_winner(board, piece):
    # Check horizontal locations for win
    for c in range(4):
        for r in range(6):
            if board[r][c] == piece and board[r][c+1] == piece and board[r][c+2] == piece and board[r][c+3] == piece:
                return True

    # Check vertical locations for win
    for c in range(7):
        for r in range(3):
            if board[r][c] == piece and board[r+1][c] == piece and board[r+2][c] == piece and board[r+3][c] == piece:
                return True

    # Check positively sloped diagonals
    for c in range(4):
        for r in range(3):
            if board[r][c] == piece and board[r+1][c+1] == piece and board[r+2][c+2] == piece and board[r+3][c+3] == piece:
                return True

    # Check negatively sloped diagonals
    for c in range(4):
        for r in range(3, 6):
            if board[r][c] == piece and board[r-1][c+1] == piece and board[r-2][c+2] == piece and board[r-3][c+3] == piece:
                return True

    return False

# Bot setup
intents = nextcord.Intents.default()
intents.message_content = True

bot = commands.Bot(command_prefix='!', intents=intents)

@bot.event
async def on_ready():
    print(f'Logged in as {bot.user} (ID: {bot.user.id})')
    print('------')

@bot.slash_command(
    name="blackjack",
    description="Play blackjack with the bot for fun!",
    guild_ids=[1245433836851040414, 781925722129170452]
)
async def blackjack(interaction: Interaction):
    deck = create_deck()
    player_hand = [deck.pop(), deck.pop()]
    dealer_hand = [deck.pop(), deck.pop()]

    message = await interaction.response.send_message(
        f"Your hand: {display_hand(player_hand)} (value: {calculate_hand_value(player_hand)})\n"
        f"Dealer's hand: {rankIcons[dealer_hand[0]['rank']]}{dealer_hand[0]['suit']} and a hidden card\n"
        "React with 🔥 to hit or ⭐ to stand."
    )
    msg = await interaction.original_message()

    await msg.add_reaction("🔥")
    await msg.add_reaction("⭐")

    def check(reaction, user):
        return user == interaction.user and str(reaction.emoji) in ["🔥", "⭐"]

    while calculate_hand_value(player_hand) < 21:
        try:
            reaction, user = await bot.wait_for('reaction_add', check=check, timeout=30.0)
        except asyncio.TimeoutError:
            await interaction.followup.send("You took too long to respond! Ending game.")
            return

        if str(reaction.emoji) == "🔥":
            player_hand.append(deck.pop())
            await msg.clear_reactions()
            await msg.edit(
                content=f"Your hand: {display_hand(player_hand)} (value: {calculate_hand_value(player_hand)})\n"
                        f"Dealer's hand: {rankIcons[dealer_hand[0]['rank']]}{dealer_hand[0]['suit']} and a hidden card\n"
                        "React with 🔥 to hit or ⭐ to stand."
            )
            await msg.add_reaction("🔥")
            await msg.add_reaction("⭐")
        elif str(reaction.emoji) == "⭐":
            break

    player_value = calculate_hand_value(player_hand)
    dealer_value = calculate_hand_value(dealer_hand)

    await msg.edit(content=f"Your hand: {display_hand(player_hand)} (value: {player_value})\n"
                           f"Dealer's hand: {display_hand(dealer_hand)} (value: {dealer_value})")

    while dealer_value < 17:
        dealer_hand.append(deck.pop())
        dealer_value = calculate_hand_value(dealer_hand)
        await interaction.followup.send(f"Dealer's hand: {display_hand(dealer_hand)} (value: {dealer_value})")

    if player_value > 21:
        await interaction.followup.send("You bust! Dealer wins.")
    elif dealer_value > 21 or player_value > dealer_value:
        await interaction.followup.send("You win!")
    elif player_value < dealer_value:
        await interaction.followup.send("Dealer wins!")
    else:
        await interaction.followup.send("It's a tie!")

@bot.slash_command(
    name="connect4",
    description="Play Connect 4 with another player!",
    guild_ids=[1245433836851040414, 781925722129170452]
)
async def connect4(interaction: Interaction):
    board = create_board()
    turn = 0
    player_symbols = [red_slot, yellow_slot]
    players = [interaction.user]
    
    def check_join(m):
        return m.author != bot.user and m.content.lower() == "join"

    await interaction.response.send_message(f"{interaction.user.mention} started a game of Connect 4! Type 'join' to join the game.")
    
    try:
        join_msg = await bot.wait_for('message', check=check_join, timeout=60.0)
        players.append(join_msg.author)
        await interaction.followup.send(f"{join_msg.author.mention} has joined the game! Let's start!\n" + display_board(board))
    except asyncio.TimeoutError:
        await interaction.followup.send("No one joined the game in time. Ending game.")
        return
    
    message = await interaction.original_message()

    for column in columns:
        await message.add_reaction(column)

    def check_reaction(reaction, user):
        return user in players and str(reaction.emoji) in columns

    while True:
        try:
            reaction, user = await bot.wait_for('reaction_add', check=check_reaction, timeout=60.0)
        except asyncio.TimeoutError:
            await interaction.followup.send(f"{players[turn].mention} took too long to respond. Ending game.")
            return

        col = columns.index(str(reaction.emoji))
        if drop_piece(board, col, player_symbols[turn]):
            if check_winner(board, player_symbols[turn]):
                await message.edit(content=f"{players[turn].mention} wins!\n\n{display_board(board)}")
                return

            turn = (turn + 1) % 2
            await message.clear_reactions()
            await message.edit(content=f"{players[turn].mention}'s turn. Select a column by reacting to the numbers.\n\n{display_board(board)}")

            for column in columns:
                await message.add_reaction(column)
        else:
            await interaction.followup.send(f"Column {col+1} is full. Choose another column.")

try:
    bot.run(DISCORD_TOKEN)
except nextcord.LoginFailure:
    print("Invalid token")
except nextcord.ConnectionClosed as e:
    print(f"Connection closed: {e.code} - {e.reason}")
except Exception as e:
    print(f"An error occurred: {e}")