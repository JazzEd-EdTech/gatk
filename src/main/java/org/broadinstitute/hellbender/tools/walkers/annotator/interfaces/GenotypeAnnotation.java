package org.broadinstitute.hellbender.tools.walkers.annotator.interfaces;

import htsjdk.variant.variantcontext.Genotype;
import htsjdk.variant.variantcontext.GenotypeBuilder;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.vcf.VCFFormatHeaderLine;
import org.broadinstitute.hellbender.engine.AlignmentContext;
import org.broadinstitute.hellbender.engine.ReferenceContext;
import org.broadinstitute.hellbender.utils.genotyper.PerReadAlleleLikelihoodMap;

import java.util.List;

/**
 * Represents an annotation that is computed for a single genotype.
 */
public abstract class GenotypeAnnotation {

    /**
     * Computes the annotation for the given genotype and the likelihoods per read.
     * Expected to modified the passed genotype builder.
     *
     * @param ref Reference context, may be null
     * @param vc Variant to be annotated. Not null.
     * @param alleleLikelihoodMap map of likelihoods per read. May be null.
     * @param g the genotype to annotate. May be null.
     * @param gb the builder to modify and annotations to. Not null.
     */
    public abstract void annotate(final ReferenceContext ref,
                                  final VariantContext vc,
                                  final Genotype g,
                                  final GenotypeBuilder gb,
                                  final PerReadAlleleLikelihoodMap alleleLikelihoodMap);

    /**
     * Return the descriptions used for the VCF FORMAT meta field
     */
    public abstract List<VCFFormatHeaderLine> getDescriptions();

    /**
     * Return the FORMAT keys
     */
    public abstract List<String> getKeyNames();
}