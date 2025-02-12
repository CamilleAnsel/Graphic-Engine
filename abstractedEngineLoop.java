/**
 * Abstract class representing the core loop of a graphics engine.
 * It manages the engine's lifecycle and execution flow.
 */
public abstract class abstractedEngineLoop {

    /** Enum representing possible engine states */
    protected enum EngineStatus {
        STOPPED,
        RUNNING
    }

    // Fields
    /**
     * Represents the current status of the engine (e.g., RUNNING, STOPPED).
     * Declared as volatile to ensure visibility across multiple threads.
     */
    protected volatile EngineStatus status;

    protected Scene scene;

    /**
     * The thread in which the graphics loop runs.
     */
    private Thread graphicsThread;

    // Build
    /**
     * Constructor that sets the initial status and set the scene.
     */
    public EngineLoop(Scene scene)
        status = EngineStatus.STOPPED;
        this.scene = scene;

    }

    // Methods
    /**
     * Starts the engine loop by setting the status to RUNNING and launching the graphics loop thread.
     */
    public void run() {
        status = EngineStatus.RUNNING;
        graphicsThread = new Thread(this::processEngineLoop);
        graphicsThread.start();
    }

    /**
     * Defines the core execution loop of the engine.
     This implementaion is basic and can be override, especially to take care of the elapsed time between two frames when updating the scene
     */
    protected void processGameLoop() {
        while (isGameRunning()) {
            processInput();
            update();
            render();
        }
    }

    /**
     * Stops the engine loop by changing the status to STOPPED.
     */
    public void stop() {
        status = EngineStatus.STOPPED;
    }

    /**
     * Checks whether the engine is currently running.
     *
     * @return true if the engine status is RUNNING, false otherwise.
     */
    public boolean isEngineRunning() {
        return status == EngineStatus.RUNNING;
    }

    // Abstracted Methods (to be implemented by subclasses.)
    /**
     * Handles input processing.
     */
    protected abstract void processInput();

    /**
     * Update variables (meshs position in the scene, camera view).
     */
    protected abstract void update();

    /**
     * Handles rendering logic.
     */
    protected abstract void render();
}
