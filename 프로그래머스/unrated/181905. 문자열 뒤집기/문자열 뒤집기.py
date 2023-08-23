def solution(my_string, s, e):
    my_string = my_string[:s] + my_string[s:e+1][::-1] + my_string[e+1:]
    return my_string