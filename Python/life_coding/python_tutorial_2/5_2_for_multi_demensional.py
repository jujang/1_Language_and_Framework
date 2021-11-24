persons = [
['egoing', 'Seoul', 'Web'],
['basta', 'Seoul', 'IoT'],
['blackdew', 'Tongyeong', 'ML']
]
print(persons[0][0])

for person in persons:
    print(person[0]+','+person[1]+','+person[2])

person = ['egoing', 'Seoul', 'Web']
name = person[0]
address = person[1]
interest = person[2]
print(name, address, interest)

name, address, interest = ['egoing', 'Seoul', 'Web']
print(name, address, interest)

for name, address, interest in persons:
    print(name+','+address+','+interest)