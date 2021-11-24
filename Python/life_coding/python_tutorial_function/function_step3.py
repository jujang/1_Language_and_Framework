def get_vat(price, vat_rate=0.1):
    return price*vat_rate
print(get_vat(10000))
print(get_vat(20000, 0.3))