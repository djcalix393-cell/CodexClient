# Codex Client — Minecraft Java 1.21.11 (Fabric)

This is a starter client-side utility mod project. It currently includes:
- Toggle Sprint (default key is unbound so it can be assigned in Controls)
- A HUD toggle state (HUD drawing can be added next)
- A mobile-friendly build workflow using GitHub Actions

## Build on Android without a PC
1. Extract this ZIP using your file manager.
2. In your browser, create a new GitHub repository.
3. Upload the *contents* of this folder to the repository (not the outer folder).
4. Open the repository's **Actions** tab and run **Build Codex Client**.
5. When the workflow finishes, open its run, download the `codex-client-jar` artifact, and extract it.
6. Copy `codex-client-0.1.0.jar` into the Fabric `mods` folder used by MJ Launcher.
7. In MJ Launcher, launch Minecraft Java 1.21.11 with Fabric.

## Important
- You need a compatible Java 21 runtime and Fabric Loader/API for Minecraft 1.21.11.
- This starter project has not been built or tested in this environment. If the build fails, the first thing to check is whether the exact Fabric Loader/API versions in `gradle.properties` are available for 1.21.11; update them to versions listed for that Minecraft version on Fabric's official pages.
- The sprint toggle is a simple client-side helper. The HUD toggle currently stores its state but does not draw a custom overlay yet.
- This is not a full hacked client. It does not include combat automation, anti-cheat bypasses, or server-cheating features.
