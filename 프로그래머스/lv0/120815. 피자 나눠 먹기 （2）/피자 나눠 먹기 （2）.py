def solution(n):
    answer = 0
    i = 1
    while True:
        if (n*i) % 6 == 0:
            return (n*i)//6
            break
        elif (n*i) % 6 != 0:
            i += 1
            
            