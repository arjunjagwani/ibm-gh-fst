import pandas as pd
data = {
  "Vehicle Type": ["Car", "Car", "Bike"],
  "Manufacturer": ["Maruti", "Toyota", "Royal Enfield"],
  "Model": ["Swift", "Corolla", "Thunderbird"]
}
df=pd.DataFrame(data)
print(df)
df.to_csv('Vehicles.csv',index=False)