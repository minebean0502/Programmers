def solution(my_string):
    answer = []
    for i in range(len(my_string)):
        if my_string[i:len(my_string)].endswith(my_string[-1]):
            answer.append(my_string[i:len(my_string)])
    return sorted(answer)