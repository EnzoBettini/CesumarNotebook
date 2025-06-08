import streamlit as st
from openai import OpenAI
import os
from dotenv import load_dotenv
load_dotenv()
OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")

modelo = OpenAI(api_key=OPENAI_API_KEY);

st.write("### Chatbot com IA");

# role system voce pode usar para definir o contexto do chatbot
# Agentes de IA modelo RAG # role user voce pode usar para definir o contexto do usuario

if not "listaMensagens" in st.session_state:
    st.session_state.listaMensagens = [];

for mensagem in st.session_state.listaMensagens:
    if mensagem["role"] == "user":
        st.chat_message("user").write(mensagem["content"]);
    elif mensagem["role"] == "assistant":
        st.chat_message("assistant").write(mensagem["content"]);

mensagem = st.chat_input("escreva sua mensagem aqui");
if mensagem:
    st.chat_message("user").write(mensagem);
    mensagem = {"role": "user", "content": mensagem};
    st.session_state.listaMensagens.append(mensagem);

    resposta_chat = modelo.chat.completions.create(
        messages = st.session_state.listaMensagens,
        model = "gpt-3.5-turbo",
        );
    resposta_chat = resposta_chat.choices[0].message.content;
    st.chat_message("assistant").write(resposta_chat);
    resposta_chat = {"role": "assistant", "content": resposta_chat};
    st.session_state.listaMensagens.append(resposta_chat);

    print(st.session_state.listaMensagens);
