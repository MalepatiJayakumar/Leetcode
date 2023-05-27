package com.practice.Revision;

public class LabelledBlocks {

	public static void main(String[] args) {

		// breaks from l3 block control reaches to l2
		l1: {
			l2: {
				l3: {
					break l3;
				}
				System.out.println("Inside l2 block");
			}
		}

		// breaks from l3 block control reaches to l1
		l1: {
			l2: {
				l3: {
					break l2;
				}
			}
			System.out.println("Inside l1 block");
		}

		// breaks from l3 block control reaches out of labeled blocks
		l1: {
			l2: {
				l3: {
					break l1;
				}
			}
		}
		System.out.println("end");

	}

}
