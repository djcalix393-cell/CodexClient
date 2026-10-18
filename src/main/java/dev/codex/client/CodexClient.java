package dev.codex.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public final class CodexClient implements ClientModInitializer {
    private static KeyMapping toggleSprintKey;
    private static KeyMapping toggleHudKey;

    private static boolean sprintEnabled = false;
    private static boolean hudEnabled = true;

    @Override
    public void onInitializeClient() {
        toggleSprintKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.codexclient.toggle_sprint",
                GLFW.GLFW_KEY_UNKNOWN,
                "category.codexclient"
        ));

        toggleHudKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.codexclient.toggle_hud",
                GLFW.GLFW_KEY_UNKNOWN,
                "category.codexclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleSprintKey.consumeClick()) {
                sprintEnabled = !sprintEnabled;
                notify(client, "Toggle Sprint: " + (sprintEnabled ? "ON" : "OFF"));
            }

            while (toggleHudKey.consumeClick()) {
                hudEnabled = !hudEnabled;
                notify(client, "Codex HUD: " + (hudEnabled ? "ON" : "OFF"));
            }

            if (sprintEnabled && client.player != null
                    && client.options != null
                    && client.player.input.hasForwardImpulse()) {
                client.options.keySprint.setDown(true);
            }
        });
    }

    private static void notify(Minecraft client, String message) {
        if (client.player != null) {
            client.player.displayClientMessage(
                    Component.literal("[Codex] " + message), true);
        }
    }

    public static boolean isHudEnabled() {
        return hudEnabled;
    }

    public static boolean isSprintEnabled() {
        return sprintEnabled;
    }
  }
