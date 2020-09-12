#version 460

uniform sampler2D textureSampler;

in vec4 outputColor;
in vec2 outputTexCoord;
out vec4 fragColor;

void main(){
	vec4 finalColor = outputColor;
	if(finalColor.a <= 0.0){ // probably not the best way to check if a color is being supplied or not, but oh well
		finalColor = vec4(1.0, 1.0, 1.0, 1.0);
	}
	fragColor = finalColor * texture(textureSampler, outputTexCoord);
}