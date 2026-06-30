import pandas as pd
data = {
  "Username": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}
df=pd.DataFrame(data)
print(df)

df.to_csv('Activity17.csv',index=False)