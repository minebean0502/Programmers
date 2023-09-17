import datetime
def solution(date1, date2):
    f_date = datetime.date(date1[0], date1[1], date1[2])
    s_date = datetime.date(date2[0], date2[1], date2[2])
    
    result = f_date < s_date
    return int(result)