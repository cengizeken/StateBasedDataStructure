import java.util.HashMap;
import java.util.Map;

public class GenericVariableStorage<S, V> {
    // Map to store variable values based on states
    private Map<S, Map<V, Double>> stateVariableMap;

    public GenericVariableStorage() {
        // Initialize the outer map for states
        stateVariableMap = new HashMap<>();
    }

    // Method to set variable value based on state
    public void setVariable(S state, V variableName, double value) {
        if (!stateVariableMap.containsKey(state)) {
            // Initialize the inner map for the new state
            stateVariableMap.put(state, new HashMap<>());
        }
        // Set the variable value
        stateVariableMap.get(state).put(variableName, value);
    }

    // Method to get variable value based on state
    public Double getVariable(S state, V variableName) {
        if (stateVariableMap.containsKey(state)) {
            return stateVariableMap.get(state).get(variableName);
        } else {
            System.out.println("Invalid state: " + state);
            return null;
        }
    }

    public static void main(String[] args) {
        GenericVariableStorage<String, String> variableStorage = new GenericVariableStorage<>();

        // Example: Set and get variable value with any type of state and variable name
        variableStorage.setVariable("AB", "variable4", 40.0);
        Double value = variableStorage.getVariable("AB", "variable4");
        System.out.println("Variable value: " + value);
    }
}
