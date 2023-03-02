from datetime import date
topicin = True
textin = True
date = date.today()
while topicin != True:
    topic = input("What is the topic for today's write?\n>")
    if topic == "":
        topicin == False

while textin != True:
    text = input("Start writing!!!\n\n\n")
    if text == " ":
        textin == False
        
