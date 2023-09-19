def solution(picture, k):
    answer = []
    for i in range(len(picture)):
        A = ""
        for j in range(len(picture[i])):
            A += picture[i][j] * k
        for l in range(k):
            answer.append(A)
    return answer