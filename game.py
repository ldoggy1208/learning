name = input("insert your name to start : ")
initial = input(f"Error found. Go no further {name}. Which direction do you search? Center isn't an option. : ")
if initial == "left":
     print(f"Wrong direction {name}. Path closing")
     input("Bad ending 1 found")
elif initial == "right":
     direction2 = input(f"Correct! Pick again {name}. : ")
     if direction2 == "left":
          print(f"Wrong direction {name}. Path closing.")
          input("bad ending 1 found")
     elif direction2 == "right":
          final = input(f"Only one more choice {name}! Choose wisely before the universe ends. : ")
          if final == "center" and name == "michael skyba":
               print("Well well well Michael. This is it huh. you figured out my secret in the code. Good job.")
               input("Michael ending found")
          elif final == "left":
               print(f"You made it out {name}! The reality is saved! All thanks to either your trial and error or your luck!")
               input("Good ending found")
          elif final == "right":
               print(f"Game over. The universe collapsed. It's all your fault {name}. You {name} will burn in the ceaseles void until the end of time. Goodbye {name}.")
               input("Bad ending 2 found")
          elif final == "center" and name != "michael skyba":
               print(f"You defy the universe's rules as it has defied yours. This puts an end to the error all caused by {name} in the first place. Hooray to {name}!")
               input("True ending found")
          elif final == "win":
               input(f"God damn {name} are you resilient. The code is Right, Right, Left.")
          elif final == "secret" and name == "secret":
               print("I'll be straight with you. The universe was never collapsing. I was just doing it for attention")
               input("true secret ending found")
          elif final == "left" and name == "malcolm":
               input("Malcolm, Malcolm, Malcolm.")
          else:
               input("Invalid input.")
     elif direction2 == "win":
          input(f"This is never going to work {name}. Give up.")
     else:
          input("Invalid input.")
elif initial == "secret":
     print("you found a secret!")
     secret = input("Secret ending 1 found")
     if secret == "secret" and name == "jay":
          input("Double secret jay. good job.")
elif initial == "win":
     input("Don't think you are getting away with that so easily.")
else:
     input("Invalid input.")

          
     
