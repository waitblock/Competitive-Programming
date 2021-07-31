def matmult(m1, m2):
    r = []
    m = []
    for i in range(len(m1)):
        for j in range(len(m2[0])):
            sums = 0
            for k in range(len(m2)):
                sums = sums+(m1[i][k]*m2[k][j])
            r.append(sums)
        m.append(r)
        r=[]
    return m

def matmult_multiple(matrix, n):
    original = matrix
    mult = matrix
    for i in range(n-1):
        mult = matmult(mult, original)
    return mult

def find_largest(edges):
    largest = 0
    for i in range(len(edges)):
        edge = edges[i]
        num1 = int(edge[0])
        num2 = int(edge[1])
        largest = max(largest,num1, num2)
    return largest

def generate_matrix(edges):
    new_matrix = []
    for i in range(find_largest(edges)):
        new_row = []
        for j in range(find_largest(edges)):
            if str(i+1)+str(j+1) in edges:
                new_row.append(1)
            else:
                new_row.append(0)
        new_matrix.append(new_row)
    return new_matrix


def find_cycles(matrix):
    counter = 0
    for i in range(len(matrix)):
        if matrix[i][i] == 1:
            counter+=1
    for i in range(len(matrix)):
        for j in range(len(matrix)):
            if matrix[i][j] == 1 and matrix[j][i] == 1:
                counter+=1
    return counter/2


def find_max_edges(matrix):
    vertex = 1
    max_edges = 0
    for i in range(len(matrix)):
        edges = 0
        for j in range(len(matrix)):
            if matrix[i][j] == 1:
                edges += 1
        temp = max_edges
        max_edges = max(edges,max_edges)
        if max_edges > temp:
            vertex = i+1
    return vertex


def sum_edges(vertex, edges):
    total = 0
    for i in range(len(edges)):
        edge = edges[i]
        if int(edge[0]) == vertex:
            total += int(edge)
    return total


def find_len_2(edges):
    mat = generate_matrix(edges)
    mul_mat = matmult(mat, mat)
    counter = 0
    # print(mul_mat)
    for i in range(len(mul_mat)):
        for j in range(len(mul_mat[0])):
            counter += mul_mat[i][j]
    return counter


def findCharacteristic(choice, edges):
    edges = edges.split(" ")
    edges = [string for string in edges if string != ""]
    if choice == 1:
        return find_cycles(generate_matrix(edges))
    if choice == 2:
        return sum_edges(find_max_edges(generate_matrix(edges)), edges)
    if choice == 3:
        return find_len_2(edges)


def main():
    choice = int(input())
    edges = input()
    print(findCharacteristic(choice, edges))


if __name__ == "__main__":
    main()
