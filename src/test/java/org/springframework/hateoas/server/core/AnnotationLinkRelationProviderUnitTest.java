/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.hateoas.server.core;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.LinkRelationProvider.LookupContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vedran Pavic
 */
class AnnotationLinkRelationProviderUnitTest {

	@Test
	void ianaLinkRelationsCanBeUsedForItemAndCollectionRelations() {

		LinkRelationProvider linkRelationProvider = new AnnotationLinkRelationProvider();

		assertThat(linkRelationProvider.getItemResourceRelFor(Resource.class)).isEqualTo(IanaLinkRelations.ITEM);
		assertThat(linkRelationProvider.getCollectionResourceRelFor(Resource.class)).isEqualTo(IanaLinkRelations.COLLECTION);
	}

	@Relation(itemRelation = IanaLinkRelations.ITEM_VALUE, collectionRelation = IanaLinkRelations.COLLECTION_VALUE)
	static class Resource {}
}