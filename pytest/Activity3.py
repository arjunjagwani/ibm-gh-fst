player1=input("Player1: Choose Rock, Paper, Scissors")
player2=input("Player2: Choose Rock, Paper, Scissors")
if player1==player2:
    print("DRAW")
elif player1=="Rock" and player2=="Scissors":
    print("Player1 wins")
elif player1=="Paper" and player2=="Rock":
    print("Player1 wins")
elif player1=="Scissors" and player2=="Rock":
    print("Player1 wins")