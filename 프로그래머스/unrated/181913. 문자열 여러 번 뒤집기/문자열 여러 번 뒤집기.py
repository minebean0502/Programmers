def solution(my_string, queries):
    for a,b in queries:
        my_string = my_string[:a] + my_string[a:b+1][::-1] + my_string[b+1:]
    return my_string