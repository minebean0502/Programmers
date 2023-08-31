def solution(price):
    if price >= 500000:
        return int(price*0.8)
    elif 500000>price >= 300000:
        return int(price*0.9)
    elif 300000>price >= 100000:
        return int(price*0.95)
    elif 100000> price:
        return int(price)