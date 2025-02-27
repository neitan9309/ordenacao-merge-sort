//Créditos para o dono do canal "Bro Code", que eu sempre recorro para procurar meus cursos (gratuitos) de programação.
//Link para o vídeo sobre estrutura de dados e algorítmos: https://youtu.be/CBYHwZcbD-s?si=NSHDQx0HUmC6M3XZ

package MergeSort;

public class Main{
	
	public static void main(String args[]) {
		int array[] = {11, 4, 13, 24, 15, 1, 0, 7, 9, 5}; //Array desorganizada com 10 posições.
		
		mergeSort(array); //Chamada do método Merge Sort.
		
		for(int i = 0; i < array.length; i++) { //Impressão dos valores da array na tela do usuário.
			System.out.print(array[i] + " ");
		}
	}
	
	private static void mergeSort(int[] array) {
		
		int length = array.length; //Variável que carrega a informação do tamanho da array.
		if(length <= 1) return; //Condicional que verifica se a array tem somente 1 ou nenhum índice.
		
		int middle = length / 2; //Variável onde se calcula o valor da metade do comprimento da array.
		int[] leftArray = new int[middle]; //Array "da esquerda", onde a quantidade de índices corresponde à variável "middle" criada na linha acima.
		int[] rightArray = new int[length - middle]; //Array "da direita", onde a quantidade de índices corresponde à "length" (tamanho da array) - "middle".
													 //Em suma separamos a array inicial na metade e assinamos esses valores em 2 novas arrays.
		
		int i = 0; //Variável "i" para a primeira "régua" de contagem.
		int j = 0; //Variável "j" para a segunda "régua" de contagem.
		
		for(; i < length; i++) { //Loop "for" preenche os valores da array "da direita" e "da esquerda" com os valores correspondentes a cada índice da array original.
			if(i < middle) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[j] = array[i];
				j++;
			}
		}
		mergeSort(leftArray); //Chamada recursiva do método "mergeSort" para continuar dividindo até que haja somente um elemento na array "da esquerda".
		mergeSort(rightArray); //Chamada recursiva do método "mergeSort" para continuar dividindo até que haja somente um elemento na array "da direita".
		merge(leftArray, rightArray, array); //Chamada do método "merge", que compara e organiza os valores e mescla as duas arrays que criamos.
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		
		int leftSize = array.length / 2; //Variável onde se calcula o valor da metade do comprimento da array.
		int rightSize = array.length - leftSize; //Variável onde fazemos o cálculo: "length" (tamanho da array) - "leftSize" (que corresponde à metade do comprimento da array).
		int i = 0, l = 0, r = 0; //Variáveis que vão nos auxiliar na contagem.
		
		while(l < leftSize && r < rightSize) { //Loop "while" responsável pelo rearranjo. Ele rodará enquanto as variáveis definidas acima forem menores que o comprimento de cada array.
			if(leftArray[l] < rightArray[r]) { //Condicional que determina se o valor do índice [l] é menor que o do índice [r], ambos valores correspondentes às arrays obtidas com o método "mergeSort".
				array[i] = leftArray[l];	   //Caso a condição seja verdadeira, o índice da array principal correspondente é reescrito com o valor de [l].
				i++; //Aumentamos a contagem para que a "régua" ande um índice para frente.
				l++; //Aumentamos a contagem para que a "régua" ande um índice para frente.
			}
			else {
				array[i] = rightArray[r]; //Caso a condição não seja verdadeira, o índice [i] da nossa array principal é substituída pelo valor de [r].
				i++;
				r++;
			}
		}
		while(l < leftSize) { //Condicional que checa se ainda há elementos restantes na "array da esquerda" e os copia. 
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) { //Condicional que checa se ainda há elementos restantes na "array da direita" e os copia. 
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}
}	