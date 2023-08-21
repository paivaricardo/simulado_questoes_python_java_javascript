import unittest

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

class FatorialTest(unittest.TestCase):
    def test_verificar_fatorial_valor_positivo(self):
        self.assertEqual(120, fatorial(5))
        self.assertEqual(720, fatorial(6))
        self.assertEqual(1, fatorial(1))
        self.assertEqual(1, fatorial(0))
        self.assertEqual(2, fatorial(2))

    def test_verificar_fatorial_valor_negativo(self):
        self.assertRaises(ValueError, fatorial, -1)
        self.assertRaises(ValueError, fatorial, -2)
        self.assertRaises(ValueError, fatorial, -3)
        self.assertRaises(ValueError, fatorial, -50)

if __name__ == "__main__":
    unittest.main()