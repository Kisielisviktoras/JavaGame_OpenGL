#version 400 core

in vec2 pass_textureCoords;
in vec3 surfaceNormal;
in vec3 toLightVector;
in vec3 toCameraVector;

out vec4 out_Colour;

uniform sampler2D textureSampler;
uniform vec3 lightColour;
uniform float shineDamper;
uniform float reflectivity;

void main(void) {

    vec3 unitNormal = normalize(surfaceNormal);
    vec3 unitLightVector = normalize(toLightVector);
    vec3 unitVectorToCamera = normalize(toCameraVector);

    float nDot1 = dot(unitNormal, unitLightVector);
    float brightness = max(nDot1, 0.2);

    vec3 diffuse = brightness * lightColour;
    vec3 lightDirection = -unitLightVector;
    vec3 reflectedLightVector = reflect(lightDirection, unitNormal);

    float specularFactor = dot(reflectedLightVector, unitVectorToCamera);
    specularFactor = max(specularFactor, 0.0);
    float dampedFactor = pow(specularFactor, shineDamper);

    vec3 finalSepcular = reflectivity * dampedFactor * lightColour;

    out_Colour = vec4(diffuse, 1.0) * texture(textureSampler, pass_textureCoords) + vec4(finalSepcular, 1.0);
}