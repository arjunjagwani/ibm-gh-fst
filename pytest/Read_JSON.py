import json
import pandas as pd
with open('currency.json','r') as myFile:
    data=myFile.read()

df=pd.read_json('currency.json',orient='index')
print(df)
obj=json.loads(data)
print("usd: ",obj['usd'])
print("eur",obj['eur'])
print("gbp: ",obj['gbp'])