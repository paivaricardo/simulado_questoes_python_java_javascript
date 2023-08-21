def fatorial(n):
    if n < 0:
        raise ValueError("Não é possível calcular o fatorial de um número negativo.")
    if n == 0:
        return 1
    else:
        resultado = 1
        for i in range(1, n+1):
            resultado *= i
        return resultado