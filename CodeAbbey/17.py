def convert_string_int_arr(iterable):
    return list(map(int, iterable))

def get_checksum(iterable):
    seed = 113
    limit = 10000007
    result = 0

    for i in range(len(iterable)):
        result += iterable[i]
        result *= seed
        result %= limit

    return result

input()

print(get_checksum(convert_string_int_arr(input().split(" "))))
