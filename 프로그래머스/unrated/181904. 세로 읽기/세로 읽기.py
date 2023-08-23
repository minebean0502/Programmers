def solution(my_string, m, c):
    A = ''
    
    for i in range(len(my_string)//m):
        if m == 1:
            return my_string
        elif m!=1:
            A += my_string[i*m+c-1]
    return A