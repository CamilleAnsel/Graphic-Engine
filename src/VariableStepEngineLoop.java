/**
 * Class representing an engine loop with a variable timestep.
 * This class implements the core loop with the added functionality of variable time steps
 * between frames. It measures the time difference between each frame to adjust the update
 * and render calls accordingly, which can help achieve smoother animation and handling of
 * varying frame rates.
 */
public class VariableStepEngineLoop extends AbstractedEngineLoop {

    // Constructor
    /**
     * Constructor that initializes the engine loop with the given scene and graphic engine.
     * It calls the constructor of the parent class `AbstractedEngineLoop` to set up the
     * necessary engine states and dependencies.
     * @param scene The scene that will be rendered and updated by the engine.
     * @param graphicEngine The graphic engine responsible for rendering the scene.
     */
    public VariableStepEngineLoop(Scene scene, AbstractedGraphicEngine graphicEngine, DisplayWindow displayWindow) {
        super(scene, graphicEngine, displayWindow);  // Calls the constructor of AbstractedEngineLoop
    }

    // Methods
    /**
     * This method is responsible for processing the main engine loop.
     * It calculates the time elapsed between frames to ensure smooth updates and rendering.
     * The loop runs as long as the engine is in the "RUNNING" state. It:
     * 1. Processes input (currently a no-op in this implementation).
     * 2. Updates the scene based on the time elapsed since the last frame.
     * 3. Renders the updated scene to the screen.
     */
    @Override
    protected void processEngineLoop() {
        var lastFrameTime = System.currentTimeMillis();  // Record the time at the start of the loop
        while (isEngineRunning()) {

            processInput();  // Process input (no input in this implementation)

            // Calculate elapsed time between frames and update the scene
            var currentFrameTime = System.currentTimeMillis();
            var elapsedTime = currentFrameTime - lastFrameTime;
            update(elapsedTime);  // Update the scene with the time difference
            lastFrameTime = currentFrameTime;  // Update the last frame time

            // Render the scene after updating
            render();
        }
    }

    /**
     * This method is responsible for handling input processing.
     * In this implementation, no input processing is done, but it can be extended
     * to handle user inputs such as keyboard or mouse events.
     */
    @Override
    protected void processInput() {
        // No input processing in this implementation
    }

    /**
     * This method updates the scene by calling the `update` method on the scene.
     * The scene is updated based on the time elapsed since the last frame.
     * The update method is responsible for updating any variables (mesh positions, camera view, etc.)
     * within the scene according to the passed `elapsedTime`.
     * @param elapsedTime The time in milliseconds since the last frame.
     */
    @Override
    protected void update(long elapsedTime) {
        scene.update(elapsedTime);  // Update the scene with the elapsed time
    }
}
