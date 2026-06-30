import requests
from bs4 import BeautifulSoup

response=requests.get("https://www.training-support.net/webelements/tables")
web_content=response.content

soup=BeautifulSoup(web_content,"html.parser")

table=soup.find('table')

for tr in table.find_all('tr'):
    header=tr.find_all('th')

    cells=tr.find_all('td')
    head=[x.text for x in header]
    row=[i.text for i in cells]
    if header:
        print(head)
    else:
        print(row)