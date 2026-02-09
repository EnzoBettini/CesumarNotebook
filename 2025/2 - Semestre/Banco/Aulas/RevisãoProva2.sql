-- ===================================================================
-- 1. INSERT INTO ... SELECT
-- ===================================================================
INSERT INTO tabela_destino(col1, col2, col_extra)
SELECT coluna1, coluna2, CURRENT_TIMESTAMP()
FROM tabela_inicio;

-- -------------------------------------------------------------------

-- 2. GROUP BY e HAVING (Filtrando resultados de agregação)
SELECT
    tipo_de_evento,
    COUNT(*) AS total_ocorrencias
FROM registros_ocorrencias
GROUP BY tipo_de_evento
HAVING COUNT(*) > 5;

-- -------------------------------------------------------------------

-- 3. UPDATE com Subconsulta
UPDATE funcionarios
SET salario = salario * 1.1
WHERE id IN (
    SELECT id_funcionario
    FROM vendas
    GROUP BY id_funcionario
    HAVING COUNT(*) > 5
);

-- -------------------------------------------------------------------

-- 4. CREATE INDEX (Otimização de Performance)
CREATE INDEX idx_email ON clientes (email);

-- -------------------------------------------------------------------

-- 5. Relatório de Agregação de RH (SUM, COUNT, HAVING, ORDER BY)
SELECT
    departamento,
    COUNT(*) AS num_funcionarios,
    SUM(salario) AS folha_pagamento
FROM funcionarios
GROUP BY departamento
HAVING SUM(salario) > 50000
ORDER BY folha_pagamento DESC;

-- -------------------------------------------------------------------

-- 6. Análise de Clientes (LEFT JOIN, COALESCE, CASE)
SELECT
    c.nome,
    COUNT(p.id) AS qtd_pedidos,
    COALESCE(SUM(p.valor), 0) AS total_gasto,
    CASE
        WHEN SUM(p.valor) > 1000 THEN 'Cliente VIP'
        WHEN SUM(p.valor) > 500 THEN 'Cliente Bom'
        ELSE 'Cliente Comum'
    END AS classificacao
FROM clientes c
LEFT JOIN pedidos p ON c.id = p.id_cliente
GROUP BY c.id, c.nome
ORDER BY total_gasto DESC;

-- -------------------------------------------------------------------

-- 7. Combinação Simples de Tabelas (INNER JOIN - Produtos e Categorias)
SELECT
    p.nome AS nome_produto,
    c.nome AS nome_categoria,
    p.preco
FROM produtos p
INNER JOIN categorias c ON p.id_categoria = c.id
ORDER BY p.preco DESC;

-- -------------------------------------------------------------------

-- 8. Média de Preços por Categoria (AVG e GROUP BY)
SELECT
    c.nome AS categoria,
    AVG(p.preco) AS media_preco
FROM categorias c
INNER JOIN produtos p ON c.id = p.id_categoria
GROUP BY c.nome
ORDER BY media_preco DESC;

-- -------------------------------------------------------------------

-- 9. Contagem e Filtragem por Marca (GROUP BY e HAVING)

-- Consulta 9.1: Contagem Simples
SELECT
    m.nome AS marca,
    COUNT(p.id) AS total_produtos
FROM marcas m
INNER JOIN produtos p ON m.id = p.id_marca
GROUP BY m.nome;

-- Consulta 9.2: Contagem com Filtragem Avançada
SELECT
    m.nome AS marca,
    COUNT(p.id) AS total_produtos
FROM marcas m
INNER JOIN produtos p ON m.id = p.id_marca
GROUP BY m.nome
HAVING COUNT(p.id) > 5
ORDER BY total_produtos DESC;
