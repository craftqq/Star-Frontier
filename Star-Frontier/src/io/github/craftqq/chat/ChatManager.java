package io.github.craftqq.chat;

import io.github.craftqq.GUI.ChatTextArea;

public interface ChatManager {
	public void send(String message);
	public void setChatArea(ChatTextArea chat);
}
