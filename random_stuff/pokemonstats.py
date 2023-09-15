import requests

def get_pokemon_stats(pokemon_name):
    url = f"https://pokeapi.co/api/v2/pokemon/{pokemon_name.lower()}"
    
    try:
        response = requests.get(url)
        response.raise_for_status()
        data = response.json()
        
        # Extract base stats
        base_stats = {}
        for stat in data['stats']:
            stat_name = stat['stat']['name']
            stat_value = stat['base_stat']
            base_stats[stat_name] = stat_value
        
        return base_stats
    
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

# Example usage:

pokemon_name = input("input pokemon name\n>")  # You can change this to any Pokémon you want
stats = get_pokemon_stats(pokemon_name)

if stats:
    print(f"Base Stats for {pokemon_name}:")
    for stat, value in stats.items():
        print(f"{stat.capitalize()}: {value}")
