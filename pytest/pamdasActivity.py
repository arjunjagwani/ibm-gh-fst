import pandas as pd
df=pd.read_csv('employees.csv')
print(df)
print(df['Salary'][4])