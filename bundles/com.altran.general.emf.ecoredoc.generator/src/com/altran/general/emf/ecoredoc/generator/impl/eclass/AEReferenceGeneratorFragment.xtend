package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.^extension.AnchorExtension
import org.eclipse.emf.ecore.EReference

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

abstract class AEReferenceGeneratorFragment extends AEStructuralFeatureGeneratorFragment<EReference, EReferenceConfigPair> {
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		super(eClassGeneratorPart)
	}
	
	override protected enumerateFeatureProperties(EReferenceConfigPair pair) {
		 #[
			defineEKeys(pair),
			defineResolveProxies(pair),
			defineContainer(pair)
		]
	}
	
	override protected combineConfigPair(EReference eReference, EClassConfig classConfig) {
		new EReferenceConfigPair(eReference, (classConfig.EContainments + classConfig.EReferences).findFirst[id == eReference.name])
	}
	
	override protected concatFeatureType(EReference eReference) {
		'''
			«this.eClassGeneratorPart.concatLinkTo(eReference.EType)»
			«getOpposite(eReference)»
		'''
	}
	
	protected def CharSequence getOpposite(EReference eReference) {
		val eOpposite = eReference.EOpposite
		
		if (eOpposite !== null) {
			val String eOppositeName = eOpposite.name
			val eReferenceType = eReference.EReferenceType
			
			'''
				«newline»
				_EOpposite:_ `<<«concatAnchor(eReferenceType)»«AnchorExtension.ANCHOR_SEPARATOR»«eOppositeName», «eOppositeName»>>`
			'''
		}
	}
}
