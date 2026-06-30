import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

data = {
  "Vehicle Type": ["Car", "Car", "Bike"],
  "Manufacturer": ["Maruti", "Toyota", "Royal Enfield"],
  "Model": ["Swift", "Corolla", "Thunderbird"]
}

df=pd.DataFrame(data)
writer=ExcelWriter("Vehicles.xlsx")
df.to_excel(writer,index=False)
writer.close()