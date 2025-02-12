public class VariableStepEngineLoop extends EngineLoop {

    @override
    protected void processEngineLoop() {
        var lastFrameTime = System.currentTimeMillis();
        while (isEngineRunning()) {

        processInput();

        var currentFrameTime = System.currentTimeMillis();
        var elapsedTime = currentFrameTime - lastFrameTime;
        update(elapsedTime);
        lastFrameTime = currentFrameTime;

        render();

        }
    }

    protected void processInput() {
        // No input
    }

    protected void update(Long elapsedTime) {
        scene.update();
    }

    protected void render() {
        // Nothing to render
    }

}
