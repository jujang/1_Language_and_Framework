input_id = input('id:')
id = 'egoing'
input_password = input('password:')
password = '111111'
if input_id == id:
    if input_password == password:
        print('Welcome')
    else:
        print('Wrong password')
else:
    print('Wrong id')