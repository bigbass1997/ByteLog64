#version 460

layout (location=0) in vec3 position;
layout (location=1) in vec4 color;
layout (location=3) in vec2 texCoord;

uniform mat4 projModelView;

out vec4 outputColor;
out vec2 outputTexCoord;

void main(){
	gl_Position = projModelView * vec4(position, 1.0);
	outputColor = color;
	outputTexCoord = texCoord;
}