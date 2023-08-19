def solution(angle):
    B = angle/90
    if B < 1 : 
        return 1
    elif B == 1 :
        return 2
    elif B < 2 :
        return 3
    else : return 4