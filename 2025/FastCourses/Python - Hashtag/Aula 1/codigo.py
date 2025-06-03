import pyautogui # Faz automação de tarefas
import time
import pandas

pyautogui.PAUSE = 0.5;
# Passo 1:  entrar no sistema da empresa - https://dlp.hashtagtreinamentos.com/python/intensivao/login
pyautogui.press('win');
pyautogui.write('Chrome');
time.sleep(1);
pyautogui.press('enter');
pyautogui.sleep(2);
pyautogui.write('https://dlp.hashtagtreinamentos.com/python/intensivao/login');
pyautogui.press('enter');

# Passo 2: fazer o login com o usuário e senha
time.sleep(2);
pyautogui.click(x=711, y=409);
pyautogui.write('teste');
pyautogui.press('tab');
pyautogui.write('123456@@353232');
pyautogui.press('enter');
time.sleep(2);

# Passo 3: Importar a base de dados
table = pandas.read_csv('./2025/FastCourses/Python - Hashtag/Aula 1/produtos.csv');
print(table);

# Passo 4: Passar o produto pro sistema
for linha in table.index:
    pyautogui.click(x=698, y=287);
    codigo = str(table.loc[linha, 'codigo']);
    marca = str(table.loc[linha, 'marca']);
    tipo = str(table.loc[linha, 'tipo']);
    categoria = str(table.loc[linha, 'categoria']);
    preco = str(table.loc[linha, 'preco_unitario']);
    custo = str(table.loc[linha, 'custo']);
    obs = str(table.loc[linha, 'obs']);

    pyautogui.write(codigo);
    pyautogui.press('tab');
    pyautogui.write(marca);
    pyautogui.press('tab');
    pyautogui.write(tipo);
    pyautogui.press('tab');
    pyautogui.write(categoria);
    pyautogui.press('tab');
    pyautogui.write(preco);
    pyautogui.press('tab');
    pyautogui.write(custo);
    if obs != 'nan':
        pyautogui.press('tab');
        pyautogui.write(obs);
        pyautogui.press('tab');
    pyautogui.press('enter');

    pyautogui.scroll(10000);
# Passo 5: repetir o processo para todos os produtos
