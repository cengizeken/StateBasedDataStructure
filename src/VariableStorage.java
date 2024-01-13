import java.util.HashMap;
import java.util.Map;

public class VariableStorage {
    // Map to store variable values based on states
    private Map<String, Map<String, Double>> stateVariableMap;

    public VariableStorage() {
        // Initialize the outer map for states
        stateVariableMap = new HashMap<>();
    }

    // Method to set variable value based on state
    public void setVariable(String state, String variableName, double value) {
        // If the state doesn't exist, initialize the inner map
        stateVariableMap.computeIfAbsent(state, k -> new HashMap<>());
        // Set the variable value
        stateVariableMap.get(state).put(variableName, value);
    }

    // Method to get variable value based on state
    public Double getVariable(String state, String variableName) {
        if (stateVariableMap.containsKey(state)) {
            return stateVariableMap.get(state).get(variableName);
        } else {
            System.out.println("Invalid state: " + state);
            return null;
        }
    }

    public static void main(String[] args) {
        VariableStorage variableStorage = new VariableStorage();

        // Example: Set and get variable value with any type of state and variable name
        variableStorage.setVariable("AB", "variable4", 40.0);
        Double value = variableStorage.getVariable("AB", "variable4");
        System.out.println("Variable value: " + value);
    }
}
