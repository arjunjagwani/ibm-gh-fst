import pandas as pd
df=pd.read_csv('Activity17.csv')
# print(df)
print(df['Username'])
print("Username: ",df['Username'][1]," | ","Password: ",df['Passwords'][1])
print(df.sort_values('Username'))
print(df.sort_values('Passwords',ascending=False))
