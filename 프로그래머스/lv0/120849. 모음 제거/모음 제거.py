def solution(my_string):
    answer = ''
    K = ["a", "e", "i", "o", "u"]
    for i in K:
        if i in my_string:
            my_string = my_string.replace(i, "")
    return my_string        
    
    