import nextcord
import os
import random
import asyncio
from dotenv import load_dotenv
from pathlib import Path
from nextcord import Interaction
from nextcord.ext import commands

env_path = Path('C:/Users/liamt/OneDrive/Documents/GitHub/learning/ICS4U1/finalProject/token.env')

if not env_path.is_file():
    raise FileNotFoundError(f"{env_path} does not exist. Ensure the file is in the correct location.")

load_dotenv(dotenv_path=env_path)

DISCORD_TOKEN = os.getenv("DISCORD_TOKEN")

if DISCORD_TOKEN is None:
    raise ValueError("DISCORD_TOKEN environment variable not found. Ensure your token.env file is correctly configured.")

suits = ['<:Hearts:1248247512389914726>', '<:Diamonds:1248142085651959870>', '<:Clubs:1248142071915876394>', '<:Spades:1248142013480570900>']
ranks = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
values = {
    '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, '10': 10,
    'J': 10, 'Q': 10, 'K': 10, 'A': 11
}
rankIcons = {
    '2': '<:Two:1248322560928780298>', '3': '<:Three:1248322584139796511>', '4': '<:Four:1248322602137686066>', '5': '<:Five:1248322620529840269>', '6': '<:Six:1248322643556434102>', '7': '<:Seven:1248322665932914733>', '8': '<:Eight:1248322681741512726>', '9': '<:Nine:1248322705447719004>', '10': '<:Ten:1248322728939753563>', 'J': '<:Jack:1248322762678997105>', 'Q': '<:Queen:1248322799618232401>', 'K': '<:King:1248322819650097204>', 'A': '<:Ace:1248322837668827279>'}

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


intents = nextcord.Intents.default()
intents.message_content = True

bot = commands.Bot(command_prefix='!', intents=intents)

@bot.event
async def on_ready():
    print(f'Logged in as {bot.user} (ID: {bot.user.id})')
    print('------')
    
    try:
        guild_ids = [1245433836851040414, 781925722129170452]  # Replace with your actual guild IDs
        for guild_id in guild_ids:
            await bot.sync_commands(guild=nextcord.Object(id=guild_id))
        print("Commands synced successfully")
    except Exception as e:
        print(f"Failed to sync commands: {e}")
        
    guild_count = 0
    for guild in bot.guilds:
        print(f"- {guild.id} (name: {guild.name})")
        guild_count += 1
    print("SampleDiscordBot is in " + str(guild_count) + " guilds.")

@bot.event
async def on_message(message):
    if message.content == "hello!":
        await message.channel.send("hey dirtbag")

@bot.slash_command(
    name="hellocommand",
    description="Make the bot say hello!",
    guild_ids=[1245433836851040414, 781925722129170452]  # Include both guild IDs
)
async def hello_command(interaction: Interaction):
    await interaction.response.send_message("Hello!")

@bot.slash_command(
    name="blackjack",
    description="Play blackjack with the bot for fun!",
    guild_ids=[1245433836851040414, 781925722129170452]
)
async def blackjack(interaction: Interaction):
    deck = create_deck()
    player_hand = [deck.pop(), deck.pop()]
    dealer_hand = [deck.pop(), deck.pop()]

    await interaction.response.send_message(f"Your hand: {display_hand(player_hand)} (value: {calculate_hand_value(player_hand)})")
    await interaction.followup.send(f"Dealer's hand: {rankIcons[dealer_hand[0]['rank']]}{dealer_hand[0]['suit']} and a hidden card")

    while calculate_hand_value(player_hand) < 21:
        await interaction.followup.send("Type `/hit` to draw another card or `/stand` to hold your hand.")
        try:
            msg = await bot.wait_for('message', check=lambda message: message.author == interaction.user, timeout=30.0)
        except asyncio.TimeoutError:
            await interaction.followup.send("You took too long to respond! Ending game.")
            return

        if msg.content.lower() == '/hit':
            player_hand.append(deck.pop())
            await interaction.followup.send(f"Your hand: {display_hand(player_hand)} (value: {calculate_hand_value(player_hand)})")
        elif msg.content.lower() == '/stand':
            break

    player_value = calculate_hand_value(player_hand)
    dealer_value = calculate_hand_value(dealer_hand)

    await interaction.followup.send(f"Dealer's hand: {display_hand(dealer_hand)} (value: {dealer_value})")

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

try:
    bot.run(DISCORD_TOKEN)
except nextcord.LoginFailure:
    print("Invalid token")
except nextcord.ConnectionClosed as e:
    print(f"Connection closed: {e.code} - {e.reason}")
except Exception as e:
    print(f"An error occurred: {e}")
