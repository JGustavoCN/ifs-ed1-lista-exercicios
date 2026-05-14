<p align="center">
  <img src="latex/geral-logo-ifs.png" alt="Logo IFS" width="300">
</p>

# Guia de Estudos - Algoritmos e Estrutura de Dados I (ED1)

### Monitor: José Gustavo Correia Nascimento

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![LaTeX](https://img.shields.io/badge/LaTeX-47A141?style=for-the-badge&logo=latex&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completo-success?style=for-the-badge)

Este repositório contém a resolução da lista de exercícios sob orientação do **Prof. Jose Solenir Lima Figueredo** (IFS - Campus Lagarto).

## 🚀 Visão Geral

O projeto está estruturado para fornecer uma experiência de aprendizado progressiva, cobrindo desde conceitos fundamentais de recursividade até estruturas de dados dinâmicas e encadeadas.

### 📊 Dashboard Interativo

Para uma visão visual e didática dos temas abordados, acesse o nosso **[Dashboard de Apresentação](index.html)** (ou acesse via GitHub Pages se disponível).

---

## 📂 Estrutura do Projeto

O repositório está organizado de forma a separar o documento acadêmico das implementações de código:

- **`/latex`**: Contém o arquivo `main.tex` com os enunciados formatados, perguntas reflexivas e requisitos de cada questão.
- **`/src`**: Contém todas as resoluções em Java, organizadas por temas:
  - `01_recursividade`: Linear, Cauda, Divisão e Conquista.
  - `02_array_primitivo`: Gestão de memória fixa e shifts.
  - `03_arraylist`: Uso de Collections e manipulação segura.
  - `04_generics`: Type Safety e Bounded Types.
  - `05_lista_simples`: Singly Linked Lists.
  - `06_lista_dupla`: Doubly Linked Lists com sentinelas.
  - `07_lista_circular`: Estruturas cíclicas.
  - `08_circular_dupla`: O ápice da flexibilidade em listas.

---

## 🧠 Metodologia Pedagógica

Cada tema é composto por 3 níveis de questões:

1. **Conceito (Warm-up):** Foca na compreensão teórica e implementação básica.
2. **Prática (Core):** Aplicação do conceito em um cenário do mundo real.
3. **Desafio (Expert):** Problemas complexos que exigem otimização e tratamento de casos de borda.

---

## 🛠️ Como Executar

### Pré-requisitos

- Java JDK 17 ou superior.

- Um compilador LaTeX (como TeX Live ou Overleaf) para visualizar o PDF da lista.

### Executando as questões Java

Cada subpasta em `src/` possui uma classe `Main.java`. Para executar via terminal:

```powershell
# Exemplo para o tema de Recursividade
cd src/tema01_recursividade/q1_conceito/
javac Main.java
java Main
```

---

## 📚 Referências Utilizadas

As questões e implementações foram fundamentadas nos seguintes clássicos da computação:

- **GOODRICH, Michael T.; TAMASSIA, Roberto.** *Estruturas de Dados e Algoritmos em Java*.
- **CORMEN, Thomas H. et al.** *Algoritmos: Teoria e Prática*.

---

## 👨‍💻 Créditos

- **Professor Orientador:** Jose Solenir Lima Figueredo
- **Monitor/Desenvolvedor:** José Gustavo Correia Nascimento

---
*Desenvolvido em Maio de 2026 para o IFS - Campus Lagarto.*
