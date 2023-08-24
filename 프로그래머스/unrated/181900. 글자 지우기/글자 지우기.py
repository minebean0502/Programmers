def solution(my_string, indices):
    answer = []
    a = ''
    for i in range(len(my_string)):
        if i in indices:
            continue
        elif i not in indices:
            answer.append(my_string[i])
    return a.join(answer)