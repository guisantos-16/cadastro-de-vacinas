# 💉 Cadastro de Vacinas

Um aplicativo móvel simples e funcional desenvolvido em **Kotlin** e **Jetpack Compose** para o cadastro e listagem de vacinas. O projeto foi estruturado com foco no aprendizado da lógica de estados e gerenciamento de dados em memória no ecossistema Android moderno.

---

## 🚀 Funcionalidades
* **Cadastro de Vacinas:** Inputs de texto para Nome, Lote e Data de Aplicação.
* **Validação Simples:** Impede o cadastro de campos vazios.
* **Lista Dinâmica:** Exibição imediata dos registros em cartões (`Card`) através de uma `LazyColumn` que reage ao estado do app.

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Kotlin
* **UI Framework:** Jetpack Compose (Declarativo)
* **Design System:** Material Design 3

## 🧠 Conceitos Praticados
1. **State Management (`remember`, `mutableStateOf`):** Gerenciamento do estado da interface reativa.
2. **Lists com Reatividade (`mutableStateListOf`):** Atualização automática da UI ao manipular a lista de dados.
3. **Componentização:** Uso de componentes modernos como `OutlinedTextField`, `Button`, `Card` e `LazyColumn`.

---
*Desenvolvido para fins de estudo e fixação de lógica em desenvolvimento Android.*
