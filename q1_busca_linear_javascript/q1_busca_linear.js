const buscaLinear = (V, I) => {
    for (elem of V) {
        if (elem == I) {
            return 1;
        }
    }

    return -1;
};