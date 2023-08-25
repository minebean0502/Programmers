def solution(str_list):
    answer = []
    j = 0
    for i in range(len(str_list)):
        if str_list[j] == "r":
            return str_list[j+1:]
            break
        elif str_list[j] == "l":
            return str_list[:j]
            break
        j += 1
    return []